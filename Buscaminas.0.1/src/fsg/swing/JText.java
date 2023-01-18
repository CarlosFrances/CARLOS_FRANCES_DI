
package fsg.swing;

import java.io.Serializable;
import java.util.function.Predicate;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JText extends JTextField implements Serializable {
    public static final String PRO_BIND = "bind";
    public static final String PRO_TEXT = "text";
    
    private Predicate<String> valido = e->true;
    private Predicate<String> completo = e->true;
    private String anterior = "";
    private String cad = getText();
    
    //private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
   
    private final DocumentListener dl = new DocumentListener(){
        @Override
        public void insertUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            firePropertyChange(PRO_BIND,anterior, cad);
            firePropertyChange(PRO_TEXT,anterior, cad);
        }
        
    };
    
    // <editor-fold defaultstate="collapsed" desc="Métodos get y set">
    public Predicate<String> getCompleto() {
        return completo;
    }

    public void setCompleto(Predicate<String> completo) {
        if(completo==null) this.completo=e->true;
        else this.completo = completo;
    }

    public Predicate<String> getValido() {
        return valido;
    }

    public void setValido(Predicate<String> valido) {
        if(valido==null) this.valido=e->true;
        else this.valido = valido;
    }
    // </editor-fold>
    
    public JText()
    {
        this.setDocument(new Documento(this));
        this.getDocument().addDocumentListener(dl);
    }
    
    public boolean estaCompleto()
    {
        return completo.test(getText());
    }
    
    public boolean estaIncompleto()
    {
        return !estaCompleto();
    }
    
    public class Documento extends PlainDocument {
        private final Object source;
        
        public Object getSource()
        {
            return source;
        }

        public Documento(Object source)
        {
            this.source=source;     
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            cad = new StringBuffer(getText(0, getLength())).insert(offs,str).toString();

            if(valido.test(cad) || cad.equals(""))
            {
                anterior = getText(0, getLength());
                super.insertString(offs, str, a);
            }
            else super.insertString(offs, "", a);
        }

        @Override
        protected void removeUpdate(AbstractDocument.DefaultDocumentEvent e)
        {
            try
            {
                cad = new StringBuffer(getText(0, getLength())).delete(e.getOffset(),e.getOffset()+e.getLength()).toString();

                if(valido.test(cad) || cad.equals(""))
                {
                    anterior = getText(0, getLength());
                    super.removeUpdate(e);
                }
                else super.insertString(
                        e.getOffset(),
                        getText(0, getLength()).substring(e.getOffset(), e.getOffset()+e.getLength())
                        ,null);
            }
            catch (BadLocationException ex)
            {
            }
        }
   }
}