package bryan.io.array;

import java.io.Serializable;

import bryan.array.Array;

public abstract class AbstractSerializbleArray<E extends Serializable> extends Array<E> implements Serializable{

    protected static final long serialVersionUID = 1L;

    public AbstractSerializbleArray(int lenght) {
        super(lenght);
        //TODO Auto-generated constructor stub
    }
    
    public AbstractSerializbleArray(){
        super();
    }
}
