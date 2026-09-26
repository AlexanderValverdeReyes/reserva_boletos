package Ventade_boletos_de_viaje;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Servicio {
    
    private String destino;
    private int cantidad;
    private double precio;
    private ArrayList<Servicio> ListaServicio= new ArrayList();
    Venta venta = new Venta();
      
    public Servicio(String destino, int cantidad, double precio) {
        this.destino = destino;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public Servicio() {

    }
    
    //Getter and Setter
    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Servicio> getServicios() {
        return this.ListaServicio;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.ListaServicio = servicios;
    }  
    DefaultTableModel modelo = new DefaultTableModel();
        
     public void CebeceraServicios(JTable tablaServicios){
       String[] cabecera = new String[]{"DESTINO","CANTIDAD DISPONIBLE","PRECIO"};
        modelo.setColumnIdentifiers(cabecera);
        tablaServicios.setModel(modelo);
    }    
       public void AgregarServicio(JTextField destino, JTextField cantidad, JTextField precio){
       if(destino.getText().trim().isEmpty() || cantidad.getText().trim().isEmpty() || precio.getText().trim().isEmpty()){
          JOptionPane.showMessageDialog(null, "Complete los campos requeridos");
       }
       else{
       this.destino=destino.getText();
       this.cantidad=Integer.parseInt(cantidad.getText());
       this.precio= Double.parseDouble(precio.getText());
        modelo.addRow(new Object[]{this.destino,this.cantidad,this.precio});
        Servicio servicio = new Servicio(this.destino, this.cantidad, this.precio);

        ListaServicio.add(servicio);
        //System.out.println("SERVICIO AGREGADO"); 
           
       }               
    }   
    public void LimpiarDatosServicios(JTextField nombre, JTextField cantidad, JTextField precio){
        nombre.setText("");
        cantidad.setText("");
        precio.setText("");
    }    
    public void eliminarfilaServicio(JTable tablaServicios){
        int fila=tablaServicios.getSelectedRow();
        if(tablaServicios.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
           modelo.removeRow(fila); 
        }
        
    }
    

}
