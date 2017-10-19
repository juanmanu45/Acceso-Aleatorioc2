/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
import VO.Contexto;
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
public class ServiciosContexto {

    private Connection connection;

    public ServiciosContexto() {
        connection = DbUtil.getConnection();
    }

    public void agregarContexto(Contexto c) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert ContextoDeNavegacion(id_constexto,link,id_Modelo) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, c.getId_contexto());
            preparedStatement.setInt(1, c.getLink());
            preparedStatement.setInt(1, c.getId_modelo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contexto> listarCon() {
        ArrayList<Contexto> contextos = new ArrayList<Contexto>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from ContextoDeNavegacion");
            while (rs.next()) {
                Contexto con=new Contexto();
                con.setId_contexto(rs.getInt("id_contexto"));
                con.setId_modelo(rs.getInt("id_Modelo"));
                con.setLink(rs.getInt("link"));

                

                contextos.add(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contextos;
    }

}
