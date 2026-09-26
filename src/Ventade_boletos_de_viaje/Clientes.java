
package Ventade_boletos_de_viaje;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Clientes {
    
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String correo;

    public Clientes(String nombre, String apellido, String dni, String celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }
    
    public Clientes() {

    }
    
    
    //Getter y Setter
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return this.dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
       DefaultTableModel modelo = new DefaultTableModel();
    public void CabeceraClientes(JTable tablaClientes){
        String[] cabecera = new String[]{"NOMBRE","APELLIDO","DNI","CELULAR","CORREO"};
        modelo.setColumnIdentifiers(cabecera);
        tablaClientes.setModel(modelo);
    }
    
    public void AgregarCliente(JTextField nombre, JTextField apellido, JTextField dni, JTextField celular,JTextField correo){
       
       this.nombre=nombre.getText();
       this.apellido=apellido.getText();
       this.dni=dni.getText();
       this.celular=celular.getText();
       this.correo=correo.getText();
       modelo.addRow(new Object[]{this.nombre,this.apellido,this.dni,this.celular,this.correo});
    }

    public void LimpiarDatosClientes(JTextField nombre, JTextField apellido, JTextField dni, JTextField celular,JTextField correo){
        nombre.setText("");
        apellido.setText("");
        dni.setText("");
        celular.setText("");
        correo.setText("");
    }
    
    public void eliminarfilaCliente(JTable tablaClientes){
        int fila=tablaClientes.getSelectedRow();
        if(tablaClientes.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
           modelo.removeRow(fila); 
        }
        
    }
    
}
