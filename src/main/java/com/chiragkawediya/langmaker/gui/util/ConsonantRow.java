package com.chiragkawediya.langmaker.gui.util;

import com.chiragkawediya.langmaker.langcomponents.alphabet.Consonants;
import javafx.beans.property.StringProperty;

public class ConsonantRow {

    private StringProperty manner;

    private Consonants bilabialUnvoiced;
    private Consonants bilabialVoiced;

    private Consonants labiodentalUnvoiced;
    private Consonants labiodentalVoiced;

    private Consonants linguolabialUnvoiced;
    private Consonants linguolabialVoiced;

    private Consonants dentalUnvoiced;
    private Consonants dentalVoiced;

    private Consonants alveolarUnvoiced;
    private Consonants alveolarVoiced;

    private Consonants postAlveolarUnvoiced;
    private Consonants postAlveolarVoiced;

    private Consonants retroFlexUnvoiced;
    private Consonants retroFlexVoiced;

    private Consonants palatalUnvoiced;
    private Consonants palatalVoiced;

    private Consonants velarUnvoiced;
    private Consonants velarVoiced;

    private Consonants uvularUnvoiced;
    private Consonants uvularVoiced;

    private Consonants epiglottalUnvoiced;
    private Consonants epiglottalVoiced;

    private Consonants glottalUnvoiced;
    private Consonants glottalVoiced;

    public Consonants getLinguolabialUnvoiced() {
        return linguolabialUnvoiced;
    }

    public void setLinguolabialUnvoiced(Consonants linguolabialUnvoiced) {
        this.linguolabialUnvoiced = linguolabialUnvoiced;
    }

    public Consonants getLinguolabialVoiced() {
        return linguolabialVoiced;
    }

    public void setLinguolabialVoiced(Consonants linguolabialVoiced) {
        this.linguolabialVoiced = linguolabialVoiced;
    }

    public ConsonantRow(StringProperty manner, Consonants bilabialUnvoiced, Consonants bilabialVoiced, Consonants labiodentalUnvoiced, Consonants labiodentalVoiced, Consonants linguolabialUnvoiced, Consonants linguolabialVoiced, Consonants dentalUnvoiced, Consonants dentalVoiced, Consonants alveolarUnvoiced, Consonants alveolarVoiced, Consonants postAlveolarUnvoiced, Consonants postAlveolarVoiced, Consonants retroFlexUnvoiced, Consonants retroFlexVoiced, Consonants palatalUnvoiced, Consonants palatalVoiced, Consonants velarUnvoiced, Consonants velarVoiced, Consonants uvularUnvoiced, Consonants uvularVoiced, Consonants epiglottalUnvoiced, Consonants epiglottalVoiced, Consonants glottalUnvoiced, Consonants glottalVoiced) {
        this.manner = manner;
        this.bilabialUnvoiced = bilabialUnvoiced;
        this.bilabialVoiced = bilabialVoiced;
        this.labiodentalUnvoiced = labiodentalUnvoiced;
        this.labiodentalVoiced = labiodentalVoiced;
        this.dentalUnvoiced = dentalUnvoiced;
        this.dentalVoiced = dentalVoiced;
        this.alveolarUnvoiced = alveolarUnvoiced;
        this.alveolarVoiced = alveolarVoiced;
        this.postAlveolarUnvoiced = postAlveolarUnvoiced;
        this.postAlveolarVoiced = postAlveolarVoiced;
        this.retroFlexUnvoiced = retroFlexUnvoiced;
        this.retroFlexVoiced = retroFlexVoiced;
        this.palatalUnvoiced = palatalUnvoiced;
        this.palatalVoiced = palatalVoiced;
        this.velarUnvoiced = velarUnvoiced;
        this.velarVoiced = velarVoiced;
        this.uvularUnvoiced = uvularUnvoiced;
        this.uvularVoiced = uvularVoiced;
        this.epiglottalUnvoiced = epiglottalUnvoiced;
        this.epiglottalVoiced = epiglottalVoiced;
        this.glottalUnvoiced = glottalUnvoiced;
        this.glottalVoiced = glottalVoiced;
        this.linguolabialUnvoiced = linguolabialUnvoiced;
        this.linguolabialVoiced = linguolabialVoiced;
    }

    public String getManner() {
        return manner.get();
    }

    public StringProperty mannerProperty() {
        return manner;
    }

    public void setManner(String manner) {
        this.manner.set(manner);
    }

    public Consonants getBilabialUnvoiced() {
        return bilabialUnvoiced;
    }

    public void setBilabialUnvoiced(Consonants bilabialUnvoiced) {
        this.bilabialUnvoiced = bilabialUnvoiced;
    }

    public Consonants getBilabialVoiced() {
        return bilabialVoiced;
    }

    public void setBilabialVoiced(Consonants bilabialVoiced) {
        this.bilabialVoiced = bilabialVoiced;
    }

    public Consonants getLabiodentalUnvoiced() {
        return labiodentalUnvoiced;
    }

    public void setLabiodentalUnvoiced(Consonants labiodentalUnvoiced) {
        this.labiodentalUnvoiced = labiodentalUnvoiced;
    }

    public Consonants getLabiodentalVoiced() {
        return labiodentalVoiced;
    }

    public void setLabiodentalVoiced(Consonants labiodentalVoiced) {
        this.labiodentalVoiced = labiodentalVoiced;
    }

    public Consonants getDentalUnvoiced() {
        return dentalUnvoiced;
    }

    public void setDentalUnvoiced(Consonants dentalUnvoiced) {
        this.dentalUnvoiced = dentalUnvoiced;
    }

    public Consonants getDentalVoiced() {
        return dentalVoiced;
    }

    public void setDentalVoiced(Consonants dentalVoiced) {
        this.dentalVoiced = dentalVoiced;
    }

    public Consonants getAlveolarUnvoiced() {
        return alveolarUnvoiced;
    }

    public void setAlveolarUnvoiced(Consonants alveolarUnvoiced) {
        this.alveolarUnvoiced = alveolarUnvoiced;
    }

    public Consonants getAlveolarVoiced() {
        return alveolarVoiced;
    }

    public void setAlveolarVoiced(Consonants alveolarVoiced) {
        this.alveolarVoiced = alveolarVoiced;
    }

    public Consonants getPostAlveolarUnvoiced() {
        return postAlveolarUnvoiced;
    }

    public void setPostAlveolarUnvoiced(Consonants postAlveolarUnvoiced) {
        this.postAlveolarUnvoiced = postAlveolarUnvoiced;
    }

    public Consonants getPostAlveolarVoiced() {
        return postAlveolarVoiced;
    }

    public void setPostAlveolarVoiced(Consonants postAlveolarVoiced) {
        this.postAlveolarVoiced = postAlveolarVoiced;
    }

    public Consonants getRetroFlexUnvoiced() {
        return retroFlexUnvoiced;
    }

    public void setRetroFlexUnvoiced(Consonants retroFlexUnvoiced) {
        this.retroFlexUnvoiced = retroFlexUnvoiced;
    }

    public Consonants getRetroFlexVoiced() {
        return retroFlexVoiced;
    }

    public void setRetroFlexVoiced(Consonants retroFlexVoiced) {
        this.retroFlexVoiced = retroFlexVoiced;
    }

    public Consonants getPalatalUnvoiced() {
        return palatalUnvoiced;
    }

    public void setPalatalUnvoiced(Consonants palatalUnvoiced) {
        this.palatalUnvoiced = palatalUnvoiced;
    }

    public Consonants getPalatalVoiced() {
        return palatalVoiced;
    }

    public void setPalatalVoiced(Consonants palatalVoiced) {
        this.palatalVoiced = palatalVoiced;
    }

    public Consonants getVelarUnvoiced() {
        return velarUnvoiced;
    }

    public void setVelarUnvoiced(Consonants velarUnvoiced) {
        this.velarUnvoiced = velarUnvoiced;
    }

    public Consonants getVelarVoiced() {
        return velarVoiced;
    }

    public void setVelarVoiced(Consonants velarVoiced) {
        this.velarVoiced = velarVoiced;
    }

    public Consonants getUvularUnvoiced() {
        return uvularUnvoiced;
    }

    public void setUvularUnvoiced(Consonants uvularUnvoiced) {
        this.uvularUnvoiced = uvularUnvoiced;
    }

    public Consonants getUvularVoiced() {
        return uvularVoiced;
    }

    public void setUvularVoiced(Consonants uvularVoiced) {
        this.uvularVoiced = uvularVoiced;
    }

    public Consonants getEpiglottalUnvoiced() {
        return epiglottalUnvoiced;
    }

    public void setEpiglottalUnvoiced(Consonants epiglottalUnvoiced) {
        this.epiglottalUnvoiced = epiglottalUnvoiced;
    }

    public Consonants getEpiglottalVoiced() {
        return epiglottalVoiced;
    }

    public void setEpiglottalVoiced(Consonants epiglottalVoiced) {
        this.epiglottalVoiced = epiglottalVoiced;
    }

    public Consonants getGlottalUnvoiced() {
        return glottalUnvoiced;
    }

    public void setGlottalUnvoiced(Consonants glottalUnvoiced) {
        this.glottalUnvoiced = glottalUnvoiced;
    }

    public Consonants getGlottalVoiced() {
        return glottalVoiced;
    }

    public void setGlottalVoiced(Consonants glottalVoiced) {
        this.glottalVoiced = glottalVoiced;
    }
}
