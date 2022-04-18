package com.project.springchatapi2.domain;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class tUsr {

    private int usrKey;

    private String usrHpNum;

    private String usrNick;

    private String usrType;

    private byte[] usrPw;

    private String usrNm;

    private String usrSex;

    private Date usrBirthDay;

    private Double usrLocLat;

    private Double usrLocLon;

    private String usrLocDet;

    private String usrEmail;

    private String usrDeviceOsType;

    private String usrDeviceModel;

    private String usrDeviceToken;

    private String usrAppVer;

    private int usrLoginFailCnt;

    private String usrPushYn;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;


}
