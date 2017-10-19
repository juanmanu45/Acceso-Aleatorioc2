/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
import VO.Esquema;
import VO.Unidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LabingXEON
 */
public class ServiciosUnidad {
    
     private Connection connection;

    public ServiciosUnidad() {
        connection = DbUtil.getConnection();
    }

    public void agregarUnidad(Unidad u) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into UnidadAbs(id_unidad,id_contexto,id_Tabla) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, u.getId_unidad());
            preparedStatement.setInt(2, u.getId_contexto());
            preparedStatement.setInt(2, u.getId_tabla());
           

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Unidad> listarU() {
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Esquemas");
            while (rs.next()) {
                Unidad u=new Unidad();

                u.setId_contexto(rs.getInt("id_contexto"));
                u.setId_unidad(rs.getInt("id_unidad"));
                u.setId_contexto(rs.getInt("id_contexto"));
                

                unidades.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unidades;
    }

    
    
}
