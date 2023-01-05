/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Model;

/**
 *
 * @author whisn
 */
public class User {
    private Integer id, statusId, levelId = 0, Salary;
    private String name, username, password, email, level, status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getLevelId() {
        if(this.levelId == null) {
            setLevelId(level);
        } 
        return this.levelId;
    }

    public void setLevelId(String level) {
        switch (level) {
                case "Owner":
                    this.levelId = 1;
                    break;
                case "Admin":
                    this.levelId = 2;
                    break;
                case "Kasir":
                    this.levelId = 3;
                    break;
                case "Kasir Magang":
                    this.levelId = 4;
                    break;
                default:
                    break;
        }
    }

    public void setLevelId(Integer i) {
        this.levelId = i;
    }
    
    public void setLevel(int levelId) {
        switch (levelId) {
                case 1:
                    this.level = "Owner";
                    break;
                case 2:
                    this.level = "Admin";
                    break;
                case 3:
                    this.level = "Kasir";
                    break;
                case 4:
                    this.level = "Kasir Magang";
                    break;
                default:
                    break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
//        return decrypt(password);
    }

    public void setPassword(char[] s) {
//        this.password = password;
        this.password = encrypt(s);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
        setLevelId(level);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Integer n) {
        this.status = (n == 1) ? "Active" : "Inactive";
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer Salary) {
        this.Salary = Salary;
    }
    
    public static String encrypt(char[] chars) {
//        char[] chars = c;
        char[] newChar = new char[chars.length];
        
        for(Integer i = 0; i < newChar.length; i++) {
            newChar[i] = (char) (chars[i]+6);
        }
        
        String string = new String(newChar);
        return string;
    }
    
    public static String decrypt(String s) {
        char[] chars = s.toCharArray();
        char[] newChar = new char[chars.length];
        
        for(Integer i = 0; i < newChar.length; i++) {
            newChar[i] = (char) (chars[i]-6);
        }
        
        String string = new String(newChar);
        return string;
    }
    
}
