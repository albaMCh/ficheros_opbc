package Ej6;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class main {

    public static void main(String[] args) {

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            Candidato candidato = new Candidato("Carlos","Madrid","si", true, "test@test.com", "123456789" ,"ESPAÑA");

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 22);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 52);
            contentStream.setLeading(14f);

            contentStream.showText("Nombre: " + candidato.getNombre());
            contentStream.newLine();

            contentStream.setFont(PDType1Font.TIMES_BOLD,13);
            contentStream.showText("Correo: " + candidato.getEmail());
            contentStream.newLine();

            contentStream.showText("Teléfono: " + candidato.getTelefono());
            contentStream.newLine();

            contentStream.showText("País: " + candidato.getPais() + ", " + candidato.getCiudad());
            contentStream.newLine();

            String traslado = "";

            if(candidato.isTipoTraslado()){

                traslado = "si";
            }
            else{

                traslado = "no";
            }

            contentStream.showText("Presencialidad: " + candidato.getPresencialidad() + " | Traslado: " + traslado);
            contentStream.newLine();


            contentStream.endText();

            // Image
            //PDImageXObject image = PDImageXObject.createFromByteArray(document, main.class.getResourceAsStream("/Users/artfern95/OneDrive/Documentos/IntelliJIDEAProjects/ficheros_opbc/E75436A5-AA9E-4C60-83F3-8150620778A6_1_105_c.jpeg").readAllBytes(), "Java Logo");
            //contentStream.drawImage(image, 20, 20, image.getWidth() / 3, image.getHeight() / 3);

            contentStream.close();

            document.save("/Users/albamolerachacon/Desktop/OpenBootCamp/ficheros_opbc/src/main/resources/documento.pdf");

        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}
