package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.UserBean;
import tw.edu.ntub.imd.birc.firstmvc.service.UserService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/user")

public class UserController {
    private final UserService userService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchUser() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(userService.searchAll(), this::addUserToObjectData)
                .build();
    }

    @PostMapping(path = "")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserBean userBean,
                                               BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        userService.save(userBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path = "")
    public ResponseEntity<String> createUser(@RequestBody UserBean userBean) {
        userService.update(userBean.getName(), userBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path = "")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "name") String name) {
        userService.delete(name);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"name"})
    public ResponseEntity<String> getUser(@RequestParam(name = "name") String name) {
        ObjectData objectData = new ObjectData();
        Optional<UserBean> userBeanOptional = userService.getById(name);
        userBeanOptional.orElseThrow(() -> new RuntimeException("查無此資料，請確認使用者姓名是否正確"));
        UserBean userBean = userBeanOptional.get();
        addUserToObjectData(objectData,userBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    private void addUserToObjectData(ObjectData objectData, UserBean userBean) {
        objectData.add("name", userBean.getName());
        objectData.add("gender", userBean.getGender().equals("0") ? "男" : "女");
        objectData.add("height", userBean.getHeight());
        objectData.add("weight", userBean.getWeight());
        objectData.add("bmi", userBean.getBmi());
    }

}