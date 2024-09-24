/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import ModeloDAO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jaime
 */
public class Categorias extends CategoriaDAO{
    private Conexion cn;
    ResultSet rs;

    public Categorias() {
    }

    public Categorias(String nombreCategoria, String generacion, int edadMinima, int edadMaxima, String genero, boolean activo) {
        super(nombreCategoria, generacion, edadMinima, edadMaxima, genero, activo);
    }
    
    
     @Override
    public void agregar() {
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        String sql = "INSERT INTO `Categorias`(`NombreCategoria`,`Generacion`,`EdadMinima`, `EdadMaxima`,`Genero`)\n"+
                     "VALUES(?,?,?,?,?);";
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getNombreCategoria());
        parametro.setString(2, getGeneracion());
        parametro.setInt(3, getEdadMinima());
        parametro.setInt(4, getEdadMaxima());
        parametro.setString(5, getGenero()); // Puedes establecerlo como activo por defecto
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
     
    @Override
   public List Listar() {
    ArrayList<CategoriaDAO> list = new ArrayList<>();
    String sql = "SELECT * FROM Categorias;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
            CategoriaDAO car = new CategoriaDAO();
            car.setNombreCategoria(rs.getString("NombreCategoria"));
            car.setGeneracion(rs.getString("Generacion"));
            car.setEdadMinima(rs.getInt("EdadMinima"));
            car.setEdadMaxima(rs.getInt("EdadMaxima"));
            car.setGenero(rs.getString("Genero"));
            car.setActivo(rs.getBoolean("Activo"));
            list.add(car);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Asegúrate de cerrar la conexión y el conjunto de resultados
        cn.cerrar_conexion();
    }
    return list;
       
}
    
    @Override
    public List Listar2() {
    ArrayList<CategoriaDAO> list = new ArrayList<>();
    String sql = "SELECT * FROM Categorias WHERE Activo = true;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
            CategoriaDAO car = new CategoriaDAO();
            car.setNombreCategoria(rs.getString("NombreCategoria"));
            car.setGeneracion(rs.getString("Generacion"));
            car.setEdadMinima(rs.getInt("EdadMinima"));
            car.setEdadMaxima(rs.getInt("EdadMaxima"));
            car.setGenero(rs.getString("Genero"));
            car.setActivo(rs.getBoolean("Activo"));
            list.add(car);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Asegúrate de cerrar la conexión y el conjunto de resultados
        cn.cerrar_conexion();
    }
    return list;
   }
    
    public void activar(String NombreCategoria) {
    String sql = "UPDATE Categorias SET Activo = true WHERE NombreCategoria = ?";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, NombreCategoria);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


  @Override
    public void modificar() {
    // Consulta SQL actualizada para modificar solo Generacion, EdadMinima y EdadMaxima
    String sql = "UPDATE categorias SET Generacion = ?, EdadMinima = ?, EdadMaxima = ? WHERE NombreCategoria = ?;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);

        // Establece los valores actualizados en el PreparedStatement
        parametro.setString(1, getGeneracion());// Nuevo valor de Generacion
        parametro.setInt(2, getEdadMinima());    // Nueva edad mínima
        parametro.setInt(3, getEdadMaxima());    // Nueva edad máxima
        parametro.setString(4, getNombreCategoria()); // Condición WHERE: Nombre de categoría actual

        // Ejecuta la actualización
        parametro.executeUpdate();

        // Realiza alguna lógica adicional si es necesario, por ejemplo, verificar si se actualizaron filas correctamente

        cn.cerrar_conexion();
    } catch (SQLException e) {
        // Manejo de excepciones, imprime o registra el error
        e.printStackTrace();
    }
}

     
  /*  @Override
    public void list(String NombreCategoria){
         String sql = "SELECT * FROM Categorias where NombreCategoria=" + NombreCategoria;
       try {
       PreparedStatement parametro;
       cn = new Conexion();
       cn.abrir_Conexion();
       parametro=(PreparedStatement)cn.conexionBD.prepareStatement(sql);
       rs = parametro.executeQuery();
           while(rs.next()){
              CategoriaDAO car = new CategoriaDAO();
              car.setNombreCategoria(rs.getString("NombreCategoria"));
              car.setGeneracion(rs.getString("Generacion"));
              car.setEdadMinima(rs.getInt("EdadMinima"));
              car.setEdadMaxima(rs.getInt("EdadMaxima"));
           }
        } catch (SQLException e) {
        }
    }*/
    
   @Override
public List<CategoriaDAO> consulta(String NombreTorneo) {
    List<CategoriaDAO> listaCategorias = new ArrayList<>(); // Inicializar la lista de categorías
    
    String sql = "SELECT c.* FROM Categorias c JOIN Torneos t ON c.NombreCategoria = t.CategoriaID WHERE t.NombreTorneo = ?";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        // Establecer el parámetro del Nombre del Torneo en la consulta preparada
        parametro.setString(1, NombreTorneo);
        rs = parametro.executeQuery();
        while (rs.next()) {
            CategoriaDAO car = new CategoriaDAO();
            car.setNombreCategoria(rs.getString("NombreCategoria"));
            car.setGeneracion(rs.getString("Generacion"));
            car.setEdadMinima(rs.getInt("EdadMinima"));
            car.setEdadMaxima(rs.getInt("EdadMaxima"));
            car.setGenero(rs.getString("Genero"));
            listaCategorias.add(car); // Agregar la categoría a la lista
        }
    } catch (SQLException e) {
        // Manejar excepciones, como imprimir el mensaje de error
        System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
    } finally {
        // Asegurarse de cerrar la conexión y los recursos ResultSet y PreparedStatement
        try {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.cerrar_conexion();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    
    return listaCategorias; // Devolver la lista de categorías
}

    
    public void desactivar(String NombreCategoria) {
    String sql = "UPDATE Categorias SET Activo = false WHERE NombreCategoria = ?";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, NombreCategoria);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    
    @Override
    public void eliminar(String NombreCategoria) {
    String sql = "DELETE FROM Categorias WHERE NombreCategoria=?";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, NombreCategoria);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
}
