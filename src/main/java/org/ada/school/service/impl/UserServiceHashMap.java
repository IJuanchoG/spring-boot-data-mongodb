package org.ada.school.service.impl;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * The type User service hash map.
 */
public class UserServiceHashMap
    implements UserService
{

    private final HashMap<String, User> usersMap = new HashMap<>();


    @Override
    public User create( User user )
    {
        usersMap.put( user.getId(), user );
        return user;
    }

    @Override
    public User findById( String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            return usersMap.get( id );
        }
        return null;
    }

    @Override
    public List<User> all()
    {
        return new ArrayList<>( usersMap.values() );
    }

    @Override
    public boolean deleteById( String id )
    {
        return usersMap.remove( id ) != null;
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            User user = usersMap.get( id );
            user.update( userDto );
            return user;
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return null;
    }


}
