package com.greskapps.sboeditor;

public class BeerStatus {

    private String availability;
    private String beer;
    private Boolean avail_Beer01;
    private Boolean avail_Beer02;
    private Boolean avail_Beer03;
    private Boolean avail_Beer04;
    private Boolean avail_Beer05;
    private Boolean avail_Beer06;
    private Boolean avail_Beer07;
    private Boolean avail_Beer08;
    private Boolean avail_Beer09;
    private Boolean avail_Beer10;
    private Boolean avail_Beer11;

    //Suppress unused constructor warning. Class is used by RealTime DB callback to construct returned data
    @SuppressWarnings("unused")
    public BeerStatus() {
    }

    @SuppressWarnings("unused")
    public BeerStatus(String beer, Boolean avail_Beer01, Boolean avail_Beer02, Boolean avail_Beer03,
                      Boolean avail_Beer04, Boolean avail_Beer05, Boolean avail_Beer06, Boolean avail_Beer07,
                      Boolean avail_Beer08, Boolean avail_Beer09, Boolean avail_Beer10, Boolean avail_Beer11) {
        this.beer = beer;
        this.avail_Beer01 = avail_Beer01;
        this.avail_Beer02 = avail_Beer02;
        this.avail_Beer03 = avail_Beer03;
        this.avail_Beer04 = avail_Beer04;
        this.avail_Beer05 = avail_Beer05;
        this.avail_Beer06 = avail_Beer06;
        this.avail_Beer07 = avail_Beer07;
        this.avail_Beer08 = avail_Beer08;
        this.avail_Beer09 = avail_Beer09;
        this.avail_Beer10 = avail_Beer10;
        this.avail_Beer11 = avail_Beer11;
    }


    public String beer() {
        return beer;
    }
    public void setBeer(String beer) {
        this.beer = beer;
    }

    public Boolean getAvail_Beer01() {
        return avail_Beer01;
    }
    public void setAvail_Beer01(Boolean avail_Beer01) {
        this.avail_Beer01 = avail_Beer01;
    }

    public Boolean getAvail_Beer02() {
        return avail_Beer02;
    }
    public void setAvail_Beer02(Boolean avail_Beer02) {
        this.avail_Beer02 = avail_Beer02;
    }

    public Boolean getAvail_Beer03() {
        return avail_Beer03;
    }
    public void setAvail_Beer03(Boolean avail_Beer03) {
        this.avail_Beer03 = avail_Beer03;
    }

    public Boolean getAvail_Beer04() {
        return avail_Beer04;
    }
    public void setAvail_Beer04(Boolean avail_Beer0) {
        this.avail_Beer04 = avail_Beer0;
    }

    public Boolean getAvail_Beer05() {
        return avail_Beer05;
    }
    public void setAvail_Beer05(Boolean avail_Beer05) {
        this.avail_Beer05 = avail_Beer05;
    }

    public Boolean getAvail_Beer06() {
        return avail_Beer06;
    }
    public void setAvail_Beer06(Boolean avail_Beer06) { this.avail_Beer06 = avail_Beer06; }

    public Boolean getAvail_Beer07() {
        return avail_Beer07;
    }
    public void setAvail_Beer07(Boolean avail_Beer07) {
        this.avail_Beer07 = avail_Beer07;
    }

    public Boolean getAvail_Beer08() {
        return avail_Beer08;
    }
    public void setAvail_Beer08(Boolean avail_Beer08) {
        this.avail_Beer08 = avail_Beer08;
    }

    public Boolean getAvail_Beer09() {
        return avail_Beer09;
    }
    public void setAvail_Beer09(Boolean avail_Beer09) {
        this.avail_Beer09 = avail_Beer09;
    }

    public Boolean getAvail_Beer10() {
        return avail_Beer10;
    }
    public void setAvail_Beer10(Boolean avail_Beer10) {
        this.avail_Beer10 = avail_Beer10;
    }

    public Boolean getAvail_Beer11() {
        return avail_Beer11;
    }
    public void setAvail_Beer11(Boolean avail_Beer11) {
        this.avail_Beer11 = avail_Beer11;
    }

}