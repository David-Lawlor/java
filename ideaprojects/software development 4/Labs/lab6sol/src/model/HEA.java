package model;

import db.UniOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Patricia on 15/02/2015.
 */
public class HEA {
    private String country;
    private ArrayList<University> ulist = new ArrayList<University>();
    private ResultSet rset;

    public HEA(String c, UniOperations uo)
    {
        rset= uo.getUnis();
        try {

            System.out.println("Num Unis"+uo.getNumUni());

           while (rset.next()) {
               ulist.add(new University(uo, rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
           }

        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<University> getUniList()
    {
        return ulist;
    }
}
