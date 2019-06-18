package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.model.UsersModel;
import com.example.demo.service.IUsersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xl
 * @since 2019-06-03
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersModel> implements IUsersService {

}
