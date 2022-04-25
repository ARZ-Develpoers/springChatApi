package com.project.springchatapi2.api.controller;

import com.project.springchatapi2.api.service.UserService;
import com.project.springchatapi2.domain.tUsr;
import com.project.springchatapi2.util.SortUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value="사용자 목록 조회",nickname="getUsers", notes="")
    @RequestMapping(value = "/get-users", method=RequestMethod.GET,produces="application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name="sort", value="정렬 목록 (reg_dt+, reg_dt-)\n 기본값 reg_dt-(생성날짜순)",required=false,dataType="String",paramType="query"),
            @ApiImplicitParam(name="offset", value="(페이징)페이징 시작 번호",required=false,dataType="int",paramType="query"),
            @ApiImplicitParam(name="limit", value="(페이징)페이징 건수",required=false,dataType="int",paramType="query"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response=tUsr.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })

    public HashMap getUsers(@RequestParam(value="sort", required=false, defaultValue="reg_dt-") String sort,
                                   @RequestParam(value="offset", required=false, defaultValue="0") int offset,
                                   @RequestParam(value="limit", required=false, defaultValue="25") int limit) throws Exception {

        HashMap<String, Object> serviceParamMap = new HashMap<>();

        String[] fields = {"reg_dt+","reg_dt-"};		//정렬 가능 기준 설정
        serviceParamMap.put("sort", SortUtil.sort(sort, fields,"reg_dt-")); //정렬 기준 셋팅
        serviceParamMap.put("offset", offset);
        serviceParamMap.put("limit", limit);

        HashMap<String, Object> rstMap = new HashMap<>();
        rstMap.putAll(serviceParamMap); //전달 받은 param 기본 셋팅
        rstMap.put("Users", userService.getUsers(serviceParamMap));

        return rstMap;
    }

    @ApiOperation(value="사용자 단건 조회",nickname="getUser", notes="")
    @RequestMapping(value = "/get-users/{usrKey}", method=RequestMethod.GET,produces="application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name="usrKey", value="사용자 id",required=true,dataType="int",paramType="path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response=tUsr.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public HashMap getNotices(
            @PathVariable int usrKey) throws Exception {
        HashMap<String, Object> rstMap = new HashMap<>();
        rstMap.put("usrKey", usrKey);
        tUsr tusr = userService.getUserByUseKey(usrKey);
        rstMap.put("tUsr", tusr);
        return rstMap;
    }

    @ApiOperation(value="사용자 수정", notes="")
    @RequestMapping(value = "/set-user/{usrKey}", method=RequestMethod.PUT,produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response=tUsr.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public int setNotice(	@PathVariable int usrKey,	@RequestBody tUsr tusr) throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        String now = df.format(new Date());

        //SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        tUsr usr = userService.getUserByUseKey(usrKey);

        usr.setUsrHpNum(tusr.getUsrHpNum());
        usr.setUsrNick(tusr.getUsrNick());
        usr.setUsrType(tusr.getUsrType());
        usr.setUsrPw(tusr.getUsrPw());
        usr.setUsrNm(tusr.getUsrNm());
        usr.setUsrSex(tusr.getUsrSex());
        usr.setUsrBirthDay(tusr.getUsrBirthDay());
        usr.setUsrLocLat(tusr.getUsrLocLat());
        usr.setUsrLocLon(tusr.getUsrLocLon());
        usr.setUsrEmail(tusr.getUsrEmail());
        usr.setUsrDeviceOsType(tusr.getUsrDeviceOsType());
        usr.setUsrDeviceModel(tusr.getUsrDeviceModel());
        usr.setUsrAppVer(tusr.getUsrAppVer());
        usr.setUsrPushYn(tusr.getUsrPushYn());

        // 수정 자 명 권한 세팅 이후 처리 예정
        usr.setState(tusr.getState());
        usr.setVer(tusr.getVer());

        int result = userService.setUser(usr);
        return result;
    }

    @ApiOperation(value="사용자 삭제", notes="")
    @RequestMapping(value = "/delete-user/{usrKey}", method=RequestMethod.DELETE,produces="application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name="usrKey", value="사용자 id",required=true,dataType="int",paramType="path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response=tUsr.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public HashMap deleteUser(@PathVariable int usrKey) throws Exception
    {
        // 공지사항 삭제
        int deleteCnt=userService.deleteUserByUsrKey(usrKey);

        //결과 전달
        HashMap<String, Object> rstMap = new HashMap<>();
        rstMap.put("usrKey", usrKey);
        rstMap.put("DeleteCnt", deleteCnt);


        return rstMap;
    }

    @ApiOperation(value="사용자 저장",nickname="addUser", notes="")
    @RequestMapping(value = "/post-user", method= RequestMethod.POST,produces="application/json")
    @ApiImplicitParams({
            //@ApiImplicitParam(name="cdGroupIds",value="(검색)코드그룹ids유형", required=false, dataType="String", paramType="query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success",response=tUsr.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    private int addUser(tUsr tUsr){
        return userService.addUser(tUsr);
    }

}
