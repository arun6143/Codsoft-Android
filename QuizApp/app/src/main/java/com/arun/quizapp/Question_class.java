package com.arun.quizapp;

public class Question_class {
    public static String[] question ={
            "Under which of the following Android is licensed?",
            " Which of the following virtual machine is used by the Android operating system?",
            "How to get a response from an activity in Android?",
            "How to stop the sevices in android?",
            "what is JSON in android? ",
    };
    public static String[][] choices ={
            {"OSS", "Sourceforge", "Apache/MIT", "None of the above"},
            {"JVM", "Dalvik virtual machine", "Simple virtual machine", "None of the above"},
            {"start Activity to Result()","start activity for result()","Bundle()","none of the above"},
            {"finish()","system.exit()","By manually","stopSelf() and StopService()"},
            {"Java Script Object Native","Java Script Oriented Notation","Java Script Object Notation","None of the above"},
    };

    public static String[] CorrectAnswers ={
"Apache/MIT","Dalvik virtual machine","start activity for result()","stopSelf() and StopService()","Java Script Object Notation"
    };
}
