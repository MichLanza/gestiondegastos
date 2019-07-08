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
import clases.Movimientos;

/**
 *
 * @author Michele
 */
public class MovimientosXml {
  private Element root;
    /** variable que contiene la localizacion del archivo xml*/
    private String fileLocation = "src//Xml//movimientos.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public  MovimientosXml() {
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
  
    private Element MovimientoXmlElement(Movimientos nMov) {
        Element mov = new Element("Movimientos");
        Element tipo = new Element("tipo");
        tipo.setText(nMov.getTipo());
        Element cantidad = new Element("cantidad");
        cantidad.setText(Float.toString(nMov.getCantidad()));
        Element descripcion = new Element("descripcion");
        descripcion.setText(nMov.getDescrpicion());
       Element categoria = new Element("categoria");
        categoria.setText(nMov.getCategoria());   
         Element mes = new Element("mes");
        mes.setText(nMov.getMes());
         Element real = new Element("real");
       real.setText(Float.toString(nMov.getReal()));
       
       mov.addContent(tipo);
       mov.addContent(cantidad);
       mov.addContent(descripcion);
      mov.addContent(categoria);
      mov.addContent(mes);
     mov.addContent(real);
     return mov;
    }


    private Movimientos movToObject(Element element) throws ParseException {
       
        Movimientos mov = new Movimientos(element.getChildText("tipo"),
                             Float.parseFloat(element.getChildText("cantidad")),
                      element.getChildText("descripcion"),
                element.getChildText("categoria"),element.getChildText("mes") ,Float.parseFloat(element.getChildText("real"))) ;
        return mov;
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

    public static Element buscar(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("categoria").getText())) {
                return e;
            }
        }
        return null;
    }
  
 
    public boolean agregarMovimiento(Movimientos mov) {
        boolean resultado = false;
        root.addContent(MovimientoXmlElement((Movimientos) mov));
        resultado = updateDocument();
        return resultado;
    }

    
    public static Element buscar2(List raiz,String mes,String tipo,String plan,String real,String descripcion,String categoria) {
        Iterator i = raiz.iterator();
        
        while (i.hasNext()) {
            Element e = (Element) i.next();
  //            if (real.equals("0") && mes.equals(e.getChild("mes").getText())&& plan.equals(e.getChild("cantidad").getText())&& descripcion.equals(e.getChild("descripcion").getText()) && categoria.equals(e.getChild("categoria").getText()) && tipo.equals(e.getChild("tipo").getText())  ) {
           if ( categoria.equals(e.getChild("categoria").getText()) && plan.equals(e.getChild("cantidad").getText()) && mes.equals(e.getChild("mes").getText())&& tipo.equals(e.getChild("tipo").getText())) {
                return e;
            }
        }
        return null;
    } 
    public Movimientos buscarMov(String mes,String plan,String real,String descripcion,String categoria,String tipo) { 
        Element aux = new Element("Movimientos");
        List Movimiento = this.root.getChildren("Movimientos");
        while (aux != null) {
            aux = buscar2(Movimiento,mes,tipo,plan,real,descripcion,categoria);
            if (aux != null) {
                try {
                    return movToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

//    public boolean actualizarMovimiento(Movimientos mov) { /////////////
//        boolean resultado = false;
//        Element aux = new Element("Movimientos");
//        List Movimientos = this.root.getChildren("Movimientos");
//        while (aux != null) {
//            aux = MovimientosXml.buscar2(Movimientos,mov.getMes(),Float.toString(mov.getCantidad()),Float.toString(mov.getReal()),mov.getDescrpicion(),mov.getDescrpicion(),mov.getTipo());
//            if (aux != null) {
//                Movimientos.remove(aux);
//                resultado = updateDocument();
//            }
//        }
//        agregarMovimiento(mov);
//        return resultado;
//    }

    public boolean borrarMov( String tipo, float plan, float real,String descripcion, String mes,String categoria) {
       
        boolean resultado = false;
        Element aux = new Element("Movimientos");
        List Movimientos = this.root.getChildren("Movimientos");
        while (aux != null) {
            aux = MovimientosXml.buscar2(Movimientos,mes,tipo,Float.toString(plan),Float.toString(real),descripcion,categoria);
            if (aux != null) {
                Movimientos.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }


  
    public ArrayList<Movimientos> todoslosMovimientos() {
        ArrayList<Movimientos> resultado = new ArrayList<Movimientos>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(movToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
     public static Element buscar(List raiz) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
          {
                return e;
            }
        }
        return null;
    }
    
     public boolean borrar() {
        boolean resultado = false;
        Element aux = new Element("Movimientos");
        List Personas = this.root.getChildren("Movimientos");
        while (aux != null) {
            aux = MovimientosXml.buscar(Personas);
            if (aux != null) {
                Personas.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

   
}
