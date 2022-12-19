package br.com.tony;

import br.com.tony.model.BookDTO;
import br.com.tony.model.CatalogDTO;
import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileReader reader = new FileReader("Dummy.xml");
            XStream stream = new XStream();
            //  Necessary to avoid UnknownFieldException when a new tag is added in xml and doesn't map in DTO
            stream.ignoreUnknownElements();

            //  Necessary for security:
            stream.allowTypesByWildcard(new String[]{
                    "br.com.tony.model.CatalogDTO"
            });

            stream.processAnnotations(CatalogDTO.class);
            stream.processAnnotations(BookDTO.class);

            CatalogDTO catalogDTO = (CatalogDTO) stream.fromXML(reader);

            System.out.println(catalogDTO);
        } catch (Exception e) {
            throw e;
        }

    }
}