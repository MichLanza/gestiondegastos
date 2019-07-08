/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import clases.Categoria;
import java.io.File;
import java.net.URISyntaxException;
import javax.swing.JComboBox;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class CategoriaXml {
  private Element root;
  
    private String fileLocation = "src//Xml//categoria.xml";
   
    public  CategoriaXml() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }
    
    
 private Element CategoriatoXmlElement(Categoria cat) {
        Element cate = new Element("Categorias");
        Element nombre = new Element("Nombre");
        nombre.setText(cat.getNombre());
            cate.addContent(nombre);
   
     return cate;
    }
    private Categoria catToObject(Element element) throws ParseException {
       
        Categoria cat = new Categoria(element.getChildText("Nombre") );
        return cat;
    }
      
    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }
     public boolean agregarCategoria(Categoria cat) {
        boolean resultado = false;
        root.addContent(CategoriatoXmlElement((Categoria) cat));
        resultado = updateDocument();
        return resultado;
    }
public ArrayList<Categoria>  todoslascategorias (){

        ArrayList<Categoria> resultado = new ArrayList<Categoria>();
        
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(catToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    
}


    
    
