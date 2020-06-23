package system.memory;

import java.util.ArrayList;
import java.util.List;

    /*
        TODO: set, get, delete
        Fazer com que tu pegue, mude, delete algo de uma paginação
        Isso vai ser usado? Se sim, implementar
        Talvez não seja necessário no primeiro momento, mas necessário mais pra frente. Não implementar se não for necessário
    */

public class MemoryManager {

    private class Pagination {
        private String name;
        private List<Integer> indexes;

        public Pagination(String name, List<Integer> indexes) {
            this.name = name;
            this.indexes = indexes;
        }

        public Integer size() {
            return indexes.size();
        }
        public String name() {
            return name;
        }
        public Integer memoryIndex(Integer index) {
            return indexes.get(index);
        }
    }

    private Memory memory;
    private List<Pagination> paginations;

    public MemoryManager() {
        memory = new Memory();
        paginations = new ArrayList<>();
    }

    public Boolean createPagination(String name, List<Object> objects) {
        List<Integer> indexes = new ArrayList<>();
        try {
            for (int i = 0; i < objects.size(); i++) {
                indexes.add(this.append(objects.get(i)));
            }
        } catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
            return false;
        }
        Pagination pagination = new Pagination(name, indexes);
        paginations.add(pagination);
        return true;
    }

    public Boolean deletePagination(String name) {
        Pagination pagination = getPagination(name);
        try {
            for (int i = 0; i < pagination.size(); i++) {
                memory.deleteIndex(pagination.memoryIndex(i));
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.printf("Error while deleting pagination \'%s\'\n", pagination.name);
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    private Integer append(Object object) throws OutOfMemoryError {
        for (Integer i = 0; i < memory.size(); i++) {
            if (memory.getFromIndex(i) == null) {
                memory.setIndexElement(i, object);
                return i;
            }
        }
        throw new OutOfMemoryError("Memory is full");
    }

    // Esses próximos métodos provavelmente não vão ser usados assim.
    // CONSIDERAR O TODO NO INÍCIO DESSE ARQUIVO!

    // private Object set(Integer index, Object object) {
    //     return memory.setIndexElement(index, object);
    // }

    // private Object getFromIndex(Integer index) {
    //     return memory.getFromIndex(index);
    // }

    // private Object deleteIndex(Integer index) {
    //     return memory.deleteIndex(index);
    // }

    private Pagination getPagination(String name) {
        for (int i = 0; i < paginations.size(); i++) {
            if (paginations.get(i).name() == name) {
                return paginations.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
		System.out.println("🆗 MEMORY MANAGER COMPILANDO!");
    } 
    
}
