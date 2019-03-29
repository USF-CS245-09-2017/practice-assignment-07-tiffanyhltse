public class ArrayList <T> implements List<T>{

    private int length;
    private int size;
    private Object [] arr; 
    private T[] newArr; 

    public ArrayList (){
        length = 10;
        size = 0;
        arr = new Object[length];
        newArr = (T[])arr;
    }

    public void add (T item){ //add item to end of list
        if(size() == newArr.length-1){
            grow_list();
        }
        newArr[size++] = item;

    }

    public void add (int pos , T item){ //add item to a given position in the list
        if (size() == newArr.length){ //when the list is full, grow the list
            grow_list();
        }

        for (int i = newArr.length - 1;i > pos;i--){
            newArr[i] = newArr[i-1];

        }
        newArr[pos] = item;
        size++;
    }


    public int size(){
        return size;
    }


    public T get(int pos){ //return item at given position
        if (pos > 0 || pos < size){
            return newArr[pos];
        }
        return null;
    }


    public T remove(int pos){ //remove item at given position
        T temp = newArr[pos];
        if (size() == 0 || pos >= size || pos < 0){ //when nothing is in the list
            // and the given position is not reachable (index out of bound)
            return null;
        }
        if (size() == newArr.length){ //when the list is full, grow the list
            grow_list();
        }
        for(int i = pos;i < newArr.length - 1;i++){ //shift all items down by 1 (hide the item at the given position)
            newArr[i]= newArr[i+1];
        }

        size--;

        return temp;

    }

    private void grow_list (){

        Object[] temp = new Object [newArr.length * 2];
        T[] newTemp = (T[]) temp ;


        for (int i = 0; i < arr.length; i++){
            newTemp[i] = newArr[i];
        }


        newArr = newTemp;
    }

}