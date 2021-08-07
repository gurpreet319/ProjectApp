package com.example.projectapp

data class DataClass(val person : WithData)
{
    data class WithData(val id : Int, val name : String, val birthday : String, val image : ImageData)
    {
        data class ImageData(val original : String)
    }
}