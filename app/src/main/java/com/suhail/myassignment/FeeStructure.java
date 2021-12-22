package com.suhail.myassignment;

import com.fasterxml.jackson.annotation.JsonProperty;
class ALLLEVEL {
    public int amount;
}

class ALLCOURSES {
    @JsonProperty("ALL_LEVEL")
    public ALLLEVEL aLL_LEVEL;
    @JsonProperty("UG")
    public UG uG;
    @JsonProperty("UG-DIPLOMA")
    public UGDIPLOMA uGDIPLOMA;
    @JsonProperty("PG")
    public PG pG;
}

class INDIAN {
    @JsonProperty("ALL_COURSES")
    public ALLCOURSES aLL_COURSES;
}

class FOREIGN {
    @JsonProperty("ALL_COURSES")
    public ALLCOURSES aLL_COURSES;
}

class NRI {
    @JsonProperty("ALL_COURSES")
    public ALLCOURSES aLL_COURSES;
}

class SAARC {
    @JsonProperty("ALL_COURSES")
    public ALLCOURSES aLL_COURSES;
}

class ExamFee {
    @JsonProperty("INDIAN")
    public INDIAN iNDIAN;
    @JsonProperty("FOREIGN")
    public FOREIGN fOREIGN;
    @JsonProperty("NRI")
    public NRI nRI;
    @JsonProperty("SAARC")
    public SAARC sAARC;
}

class UG {
    public int amount;
}

class UGDIPLOMA {
    public int amount;
}

class PG {
    public int amount;
}

class ApplicationFee {
    @JsonProperty("INDIAN")
    public INDIAN iNDIAN;
    @JsonProperty("FOREIGN")
    public FOREIGN fOREIGN;
}

class FeeStructure {
    @JsonProperty("Exam Fee")
    public ExamFee examFee;
    @JsonProperty("Application Fee")
    public ApplicationFee applicationFee;
}

