package com.selenium.Day3;

public class xPath {
   
    /* 
    Two Types : 
    1. Absolute xPath - Starts with '/' e.g: /html/head/body/div/input/
    2. Relative XPath - Represented by '//'
     */


    // /html/body/div/div/div[3]/div[2]/div[2]/form/div[2]/input
    // //input[@id='txtUsername']

    // XPath = //tagname[@Attribute=’Value’]
            // //tagname[contains(@attribute,constantvalue)]
// OR  XPath = //tagname[@attribute1=value1 OR @attribute2=value1]
// AND XPath = //tagname[@attribute1=value1 AND @attribute2=value1]
            // //tagname[text()=’Text of the Web Element’]
            // //tagname[starts-with(@attribute,value)]
            // //tagname[@attribute=’value’][Index Number]
            // //tagname1[@attribute1=value1]//tagname2[@attribute2=value2]
    

    // XPath Axes
    // //tagname[@attribute=’value’]//following::tagname
    // //tagname[@attribute=’value’]//following-sibiling::tagname
    
    // //tagname[@attribute=’value’]//preceding::tagname
    // //tagname[@attribute=’value’]//preceding-sibling::tagname

    // //tagname[@attribute=’value’]//child::tagname
    // //tagname[@attribute=’value’]//parent::tagname

    // //tagname[@attribute=’value’]//descendants::tagname (descendants = child, grandchild nodes)
    // //tagname[@attribute=’value’]//ancestors::tagname

    

}
