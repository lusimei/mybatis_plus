package com.mieasy.plus.service.impl;

import com.mieasy.plus.entity.User;
import com.mieasy.plus.mapper.UserMapper;
import com.mieasy.plus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chad
 * @since 2021-01-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
