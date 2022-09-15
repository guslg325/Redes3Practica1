package controller;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class AgentManager {
    private String filePath;
    
    public AgentManager(){
        filePath = getPath()+"/agents.txt";
    }
    
    public void addAgent(SNMPAgent a){        
        try {
            if(Files.exists(Paths.get(filePath)) && !Files.readString(Paths.get(filePath)).isBlank()){
                String agent = "\n"+a.getVersion()+" "+
                    a.getCommunity()+" "+
                    a.getAddress()+" "+
                    a.getPort();
                Files.write(Paths.get(filePath), agent.getBytes(), StandardOpenOption.APPEND);
            }else{
                String agent = a.getVersion()+" "+
                    a.getCommunity()+" "+
                    a.getAddress()+" "+
                    a.getPort();
                Files.write(Paths.get(filePath), agent.getBytes());
            }                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void removeAgent(int index){
        try {
            ArrayList<SNMPAgent> agents = getAllAgents();
            String newList = "";
            int i = 0;
            
            agents.remove(index);
            
            if(agents.isEmpty()){
                Files.write(Paths.get(filePath), newList.getBytes());
            }else{
                for(i = 0; i < agents.size()-1; i++){
                    SNMPAgent agent = agents.get(i);
                    newList += agent.getVersion()+" "+agent.getCommunity()+" "+agent.getAddress()+" "+agent.getPort()+"\n";
                }

                SNMPAgent agent = agents.get(i);
                newList += agent.getVersion()+" "+agent.getCommunity()+" "+agent.getAddress()+" "+agent.getPort();

                Files.write(Paths.get(filePath), newList.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(AgentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<SNMPAgent> getAllAgents(){
        String fileContent = "";
        String[] plainAgents;
        ArrayList<SNMPAgent> agents = new ArrayList<SNMPAgent>();
        
        if(Files.exists(Paths.get(filePath))){
            try {
                fileContent = Files.readString(Paths.get(filePath));
            } catch (IOException ex) {
                Logger.getLogger(AgentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!fileContent.isBlank()){
                //Split file contents in lines
                plainAgents = fileContent.split("\n");

                //Split each line in 
                for(String plainAgent:plainAgents){
                    String[] plainAgentProperties = plainAgent.split(" ");
                    SNMPAgent a = new SNMPAgent(plainAgentProperties[1],
                                        plainAgentProperties[0],
                                        plainAgentProperties[2],
                                        plainAgentProperties[3]);
                    agents.add(a);
                }
                return agents;
            }
        }
        return null;
    }
    
    public int generatePDF(int index){
        /*
        *   Return values:
        *   0: All OK
        *   1: Timeout
        *   2: Error while generating PDF
        */
        try{
            ArrayList<SNMPAgent> agents = getAllAgents();
            SNMPAgent agent = agents.get(index);
            String os="",agentName="",contact="",location="",ifNumber="",ifTable="";
            
            //*************Get OS*************
            String command = "snmpget -v"+agent.getVersion()+
                    " -c "+agent.getCommunity()+
                    " "+agent.getAddress()+" 1.3.6.1.2.1.1.1.0";
            
            Process proc = Runtime.getRuntime().exec(command);

            // Reading the output
            BufferedReader reader =  
                  new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = "";
            while((line = reader.readLine()) != null) {
                os+=line;
            }
            proc.waitFor(); 
            reader.close();
            
            if(os.indexOf("Timeout")!=-1||os.isBlank())
                //Agent not connected
                return 1;
            
            if(os.indexOf("Linux")!=-1){
                //Linux detected
                os = "\"Linux\"";
            }else if(os.indexOf("Windows")!=-1){
                //Windows detected
                os = "\"Windows\"";
            }else if(os.indexOf("macOS")!=-1){
                //MacOS detected
                os = "\"macOS\"";
            }else{
                //No OS detected
                os = "Not detected";
            }
            System.out.println("OS: "+os);
            
            //*************Get agent name*************
            command = "snmpget -v"+agent.getVersion()+
                    " -c "+agent.getCommunity()+
                    " "+agent.getAddress()+" 1.3.6.1.2.1.1.5.0";
            
            proc = Runtime.getRuntime().exec(command);

            // Reading the output
            reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));

            line = "";
            while((line = reader.readLine()) != null) {
                agentName+=line;
            }
            proc.waitFor(); 
            reader.close();
            
            agentName = agentName.split(": ")[1];
            System.out.println("Name: "+agentName);

            //*************Get contact info*************
            command = "snmpget -v"+agent.getVersion()+
                    " -c "+agent.getCommunity()+
                    " "+agent.getAddress()+" 1.3.6.1.2.1.1.4.0";
            
            proc = Runtime.getRuntime().exec(command);

            // Reading the output
            reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));

            line = "";
            while((line = reader.readLine()) != null) {
                contact+=line;
            }
            proc.waitFor(); 
            reader.close();
            
            contact = contact.split(": ")[1];
            System.out.println("Contact information: "+contact);
            
            //*************Get location*************
            command = "snmpget -v"+agent.getVersion()+
                    " -c "+agent.getCommunity()+
                    " "+agent.getAddress()+" 1.3.6.1.2.1.1.6.0";
            
            proc = Runtime.getRuntime().exec(command);

            // Reading the output
            reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));

            line = "";
            while((line = reader.readLine()) != null) {
                location+=line;
            }
            proc.waitFor(); 
            reader.close();
            
            location = location.split(": ")[1];
            System.out.println("System location: "+location);
            
            //*************Get interface number*************
            command = "snmpget -v"+agent.getVersion()+
                    " -c "+agent.getCommunity()+
                    " "+agent.getAddress()+" 1.3.6.1.2.1.2.1.0";
            
            proc = Runtime.getRuntime().exec(command);

            // Reading the output
            reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));

            line = "";
            while((line = reader.readLine()) != null) {
                ifNumber+=line;
            }
            proc.waitFor(); 
            reader.close();
            
            ifNumber = ifNumber.split(": ")[1];
            System.out.println("Interface number: "+ifNumber);
            
            for(int i = 1; i <= Integer.parseInt(ifNumber); i++){
                //Get state for each interface 1.3.6.1.2.1.2.2.1.7.
                String status="";
                command = "snmpget -v"+agent.getVersion()+
                    " -c "+agent.getCommunity()+
                    " "+agent.getAddress()+" 1.3.6.1.2.1.2.2.1.7."+i;
            
                proc = Runtime.getRuntime().exec(command);

                // Reading the output
                reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));

                line = "";
                while((line = reader.readLine()) != null) {
                    status+=line;
                }
                proc.waitFor(); 
                reader.close();
                
                status = status.split(": ")[1];
                
                switch(status){
                    case "1":
                        status = "UP";
                        break;
                    case "2":
                        status = "DOWN";
                        break;
                    case "3":
                        status = "TEST";
                        break;
                    default:
                        status = "undefined";
                }
                ifTable += "Interface "+i+" status: "+status+"\n";
                System.out.print(ifTable);
            }
            
            //*************PDF Generator section*************
            String file = getPath()+"/"+agent.getAddress()+"_report.pdf";
                
            PdfWriter wrtr = new PdfWriter(file);
            PdfDocument pdfDoc = new PdfDocument(wrtr);
            Document doc = new Document(pdfDoc);

            PdfFont myFontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont myFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            Paragraph p1 = new Paragraph();
            p1.add("Reporte del agente "+agent.getAddress());
            p1.setTextAlignment(TextAlignment.CENTER);
            p1.setFont(myFontBold);
            p1.setFontSize(18);

            Paragraph p2 = new Paragraph();
            p2.add("Sistema operativo:\t\t\t\t\t"+os);
            p2.setTextAlignment(TextAlignment.LEFT);
            p2.setFont(myFont);
            p2.setFontSize(14);

            Paragraph p3 = new Paragraph();
            p3.add("Nombre de agente:\t\t\t\t\t"+agentName);
            p3.setTextAlignment(TextAlignment.LEFT);
            p3.setFont(myFont);
            p3.setFontSize(14);

            Paragraph p4 = new Paragraph();
            p4.add("Información de contacto:\t\t\t"+contact);
            p4.setTextAlignment(TextAlignment.LEFT);
            p4.setFont(myFont);
            p4.setFontSize(14);

            Paragraph p5 = new Paragraph();
            p5.add("Cantidad de interfaces de red:\t"+ifNumber);
            p5.setTextAlignment(TextAlignment.LEFT);
            p5.setFont(myFont);
            p5.setFontSize(14);

            Paragraph p6 = new Paragraph();
            p6.add("Estado de interfaces de red");
            p6.setTextAlignment(TextAlignment.LEFT);
            p6.setFont(myFontBold);
            p6.setFontSize(14);

            Paragraph p7 = new Paragraph();
            p7.add(ifTable);
            p7.setTextAlignment(TextAlignment.LEFT);
            p7.setFont(myFont);
            p7.setFontSize(14);

            doc.add(p1);
            doc.add(p2);
            doc.add(p3);
            doc.add(p4);
            doc.add(p5);
            doc.add(p6);
            doc.add(p7);

            doc.close();
            
            return 0;
        }catch(Exception e){
            return 2;
        }
    }
    
    private String getPath(){
        String absolutePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("/"));
        absolutePath = absolutePath.replaceAll("%20"," ");
        return absolutePath;
    }
}
