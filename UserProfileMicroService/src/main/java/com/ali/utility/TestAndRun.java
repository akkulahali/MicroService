package com.ali.utility;

import com.ali.manager.IElasticServisManager;
import com.ali.repository.entity.UserProfile;
import com.ali.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestAndRun {
    private final UserProfileService userProfileService;
    private final IElasticServisManager elasticServisManager;
   // @PostConstruct
    public void init(){
        /**
         * Bu kısım kullanılacak ise, zorunlu durumlar için işiniz bitince
         * bu kodu yorum satırına almak doğru olacaktır.
         * çalışması sistemi etkilemeyen durumlarda thred içinde çalıştırmak doğru olaacktr.
         */
//        new Thread(()->{
//            run();
//        });
        //run();
    }
    public void run(){
        List<UserProfile> list = userProfileService.findAll();
        list.forEach(x->{
            elasticServisManager.addUser(x);
        });
    }
}
