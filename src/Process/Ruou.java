/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.MyDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hung
 */
public class Ruou {
    MyDatabase cn = new MyDatabase();
    public ResultSet ShowLoaiRuou() throws SQLException {
        cn.MyDatabase();
        String sql = "SELECT MaRuou, TenRuou,Loairuou FROM RUOU as a, PHANLOAI as d where a.MaLoaiRuou = d.MaLoaiRuou";
        return cn.loadData(sql);
    }
    public void insertLoaiRuou(String MaRuou, String TenRuou, String MaLoaiRuou){
        String sql = "INSERT INTO Ruou values(\'" + MaRuou +"\',N\'"+TenRuou+"\'+,N\'"+MaLoaiRuou+"\')";
        cn.updateData(sql);
    }
   public void updateLoaiRuou(String MaRuou, String TenRuou , String MaLoaiRuou){
        String sql = "UPDATE LoaiSP set TenRuou=N'"+TenRuou+"' WHERE MaLoai='"+MaRuou+"','"+MaLoaiRuou+"'";
        cn.updateData(sql);
    }
    
}
