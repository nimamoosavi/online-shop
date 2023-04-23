package com.charisma.common.mapper;




import java.util.List;



/**
 * @param <T> is the object class
 * @param <S> is request view model that you must create and added
 * @author nima
 * @version 1.0.1
 * @apiNote this class used for map compile time and used is the protocol that implements by mapStruct library version 1.3.1.Final
 * you must create interface and extended it you must create interface and extended it
 * @apiNote is the protocol that implement by mapStruct library version 1.3.1.Final
 */
public abstract class Mapper<T, S> {

    /**
     * @param source is the source of request view model
     * @return the T is the Object
     * @apiNote method used for cast request to BaseObject
     */
    public abstract T requestToSource(S source);

    /**
     * @param target the BaseObject of object
     * @return the Request view model
     * @apiNote method used for cast BaseObject to Response View Model
     */
    public abstract S toRequestModel(T target);

    /**
     * @param sourceList the list of Request view Model
     * @return the list of BaseObject
     * @apiNote method used for cast List Response View Model to List BaseObject
     */
    public abstract List<T> requestToSource(List<S> sourceList);

    /**
     * @param targetList the list of Response View Model
     * @return the List Of Request View Model
     * @apiNote method used for cast List Response View Model to List Request View Model
     */
    public abstract List<S> toRequestModel(List<T> targetList);

}
