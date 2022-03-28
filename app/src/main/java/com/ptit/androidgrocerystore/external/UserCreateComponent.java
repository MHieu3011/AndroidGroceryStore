package com.ptit.androidgrocerystore.external;

import com.ptit.androidgrocerystore.external.task.UserCreateTask;

import net.jodah.failsafe.Failsafe;

public class UserCreateComponent extends AbstractExternalComponent {

    public String getUserCreateComponent(String userName, String fullName, String password, String address) throws Exception {
        try {
            String apiResult = Failsafe.with(retryPolicy).get(
                    () -> new UserCreateTask(userName, fullName, password, address).performTask()
            );
            String result = gson.fromJson(apiResult, String.class);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return createDefaultResponse();
        }
    }

    private String createDefaultResponse() {

        return "Error";
    }

}
