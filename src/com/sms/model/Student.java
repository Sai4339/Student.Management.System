package com.sms.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private int javaMarks;
    private int dsaMarks;
    private int dbmsMarks;
    private int osMarks;
    private int cnMarks;
    public Student(int id,String name,int age,String course,int javaMarks,int dsaMarks,int dbmsMarks,int osMarks,int cnMarks){
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
        this.javaMarks = javaMarks;
        this.dsaMarks = dsaMarks;
        this.dbmsMarks = dbmsMarks;
        this.osMarks = osMarks;
        this.cnMarks = cnMarks;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCourse(){
        return course;
    }
    public int getJavaMarks(){return javaMarks;}
    public int getDsaMarks(){return dsaMarks;}
    public int getDbmsMarks(){return dbmsMarks;}
    public int getOsMarks(){return osMarks;}
    public int getCnMarks(){return cnMarks;}
    public int setId(int id){
        this.id=id;
        return id;
    }
    public String setName(String name){
        this.name=name;
        return name;
    }
    public int setAge(int age){
        this.age=age;
        return age;
    }
    public String setCourse(String course){
        this.course=course;
        return course;
    }
    public int setJavaMarks(int javaMarks){
        this.javaMarks=javaMarks;
        return javaMarks;
    }
    public int setDsaMarks(int dsaMarks){
        this.dsaMarks=dsaMarks;
        return dsaMarks;
    }
    public int setDbmsMarks(int dbmsMarks){
        this.dbmsMarks=dbmsMarks;
        return dbmsMarks;
    }
    public int setOsMarks(int osMarks){
        this.osMarks=osMarks;
        return osMarks;
    }
    public int setCnMarks(int cnMarks){
        this.cnMarks=cnMarks;
        return cnMarks;
    }
    public int getTotalMarks() {
        return javaMarks + dsaMarks + dbmsMarks + osMarks + cnMarks;
    }
    public double getAverageMarks() {
        return getTotalMarks() / 5.0;
    }
    public String getGrade() {
        double avg = getAverageMarks();
        if (avg >= 90)
            return "A+";
        else if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "F";
    }
    @Override
    public String toString(){
        return "Id: "+id+", Name: "+name+", Age: "+age+", Course:"+course;
    }
}
