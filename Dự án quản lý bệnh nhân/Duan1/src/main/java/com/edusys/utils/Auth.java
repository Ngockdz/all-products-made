/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import com.edusys.entity.BenhNhan;

/**
 *
 * @author anime
 */
public class Auth {
    
    public static BenhNhan user = null;
    
    
    public static void clear(){
        Auth.user = null;
    }
    
    public static int isLogin(){
         if(Auth.user != null){
            return 1;
        }
        return  0;
    }
    public static int isManager(){
        if(Auth.user != null){
            return 1;
        }
        return  0;
    }
    
}
