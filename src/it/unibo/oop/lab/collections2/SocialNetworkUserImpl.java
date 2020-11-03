package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	private final Map<U, String> followed = new HashMap<>();
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	public SocialNetworkUserImpl(String name, String surname, String user) {
		super(name, surname, user);
	}

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    public boolean addFollowedUser(final String circle, final U user) {
    	
    	if (this.followed.containsKey(user)) {
    		return false;
    	}
    	
    	this.followed.put(user, circle);
    	return true;
    }


    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Collection<U> returnValue = new HashSet<>();
    	
    	for (Entry<U, String> user : this.followed.entrySet()) {
    		if (user.getValue().equals(groupName)) {
    			returnValue.add(user.getKey());
    		}
    	}
    	
        return returnValue;
    }


    public List<U> getFollowedUsers() {
        return new ArrayList<>(this.followed.keySet());
    }

}
