package com.example.androidhomework

class ComputerSetting (private val setting: Builder) {

    fun processorName() = setting.nameOfVideoCard
    fun processorPower() = setting.powerOfVideoCard
    fun playGame() = setting.videoCard

    companion object Builder{
        var nameOfVideoCard: String = "Nvidia Gforce 4080TI"
        var powerOfVideoCard: Int = 4000
        var videoCard: Boolean = false

        fun setNameOfVideoCard(nameOfVideoCard: String) = apply { this.nameOfVideoCard = nameOfVideoCard }
        fun setPowerOfVideoCard(powerOfVideoCard: Int) = apply { this.powerOfVideoCard = powerOfVideoCard }
        fun setVideoCard(videoCard: Boolean) = apply { this.videoCard = videoCard }
    }
}