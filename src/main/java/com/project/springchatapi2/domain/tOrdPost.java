package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tOrdPost {
    private int opKey;

    private String opTitle;

    private String opCont;

    private String opStoreNm;

    private double opDlLat;

    private double opDlLon;

    private String opDlDet;

    private int opLimitUsrCnt;

    private String opMenuUrl;

    private String opStoreUrl;

    private String opRegUsrKey;

    private String opDlDt;

    private String opState;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;

}
