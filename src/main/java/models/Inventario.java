package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventario {


    @SerializedName("{{PetStatus-Updated}}")
    private int petStatusUpdated;

    @SerializedName("sold")
    private int sold;

    @SerializedName("string")
    private int string;

    @SerializedName("Knopka and Luna are playing and barking")
    private int knopkaAndLunaArePlayingAndBarking;

    @SerializedName("pending")
    private int pending;

    @SerializedName("available")
    private int available;

    @SerializedName("peric")
    private int peric;

    @SerializedName("Knop and Lun are playing and barking")
    private int knopAndLunArePlayingAndBarking;

    @SerializedName("Kaki and Ui are playing and eating snacks")
    private int kakiAndUiArePlayingAndEatingSnacks;

    @SerializedName("xyz")
    private int xyz;

    @SerializedName("LaLu and Luna are playing and barking")
    private int laLuAndLunaArePlayingAndBarking;

    @SerializedName("Funny Dog")
    private int funnyDog;

    @SerializedName("Mashka and Goga are playing and barking")
    private int mashkaAndGogaArePlayingAndBarking;

    public int getPetStatusUpdated() {
        return petStatusUpdated;
    }

    public int getSold() {
        return sold;
    }

    public int getString() {
        return string;
    }

    public int getKnopkaAndLunaArePlayingAndBarking() {
        return knopkaAndLunaArePlayingAndBarking;
    }

    public int getPending() {
        return pending;
    }

    public int getAvailable() {
        return available;
    }

    public int getPeric() {
        return peric;
    }

    public int getKnopAndLunArePlayingAndBarking() {
        return knopAndLunArePlayingAndBarking;
    }

    public int getKakiAndUiArePlayingAndEatingSnacks() {
        return kakiAndUiArePlayingAndEatingSnacks;
    }

    public int getXyz() {
        return xyz;
    }

    public int getLaLuAndLunaArePlayingAndBarking() {
        return laLuAndLunaArePlayingAndBarking;
    }

    public int getFunnyDog() {
        return funnyDog;
    }

    public int getMashkaAndGogaArePlayingAndBarking() {
        return mashkaAndGogaArePlayingAndBarking;
    }
}
