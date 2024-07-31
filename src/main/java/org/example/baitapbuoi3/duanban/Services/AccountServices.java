package org.example.baitapbuoi3.duanban.Services;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.assignmentj6.Entity.Account;
import org.example.baitapbuoi3.assignmentj6.Repository.AccountInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServices {
    private final AccountInterface accountServices;
    public Account findByUsername(String account) {
        return accountServices.findByUser1(account);
    }
}
