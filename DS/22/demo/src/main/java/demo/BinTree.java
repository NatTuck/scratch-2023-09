package demo;

public interface BinTree<T extends Comparable<T>> {
    boolean isLeaf();

    boolean contains(T item);
    BinTree<T> insert(T item);
    BinTree<T> delete(T item);

    BinTree<T> merge(BinTree<T> that);

    T data();
    BinTree<T> left();
    BinTree<T> right();
}

record BinLeaf<T extends Comparable<T>>() implements BinTree {
    @Override 
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public BinTree<T> insert(T item) {
        return new BinBranch<T>(item, this, this);
    }

    @Override
    public BinTree<T> merge(BinTree<T> that) {
        return that;
    }

    @Override
    public BinTree<T> delete(T item) {
        return this;
    }

    @Override
    public T data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinTree<T> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinTree<T> right() {
        throw new RuntimeException("leaf");
    }
}

record BinBranch<T extends Comparable<T>>(
             T data, BinTree<T> left, BinTree<T> right
        ) implements BinTree {
    @Override 
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        int cmp = item.compareTo(this.data());
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left().contains(item);
        }
        else {
            return this.right().contains(item);
        }
    }

    @Override
    public BinTree<T> insert(T item) {
        int cmp = item.compareTo(this.data());
        if (cmp == 0) {
            return this;
        }
        if (cmp < 0) {
            return this.left().insert(item);
        }
        else {
            return this.right().insert(item);
        }
    }

    @Override
    public BinTree<T> merge(BinTree<T> that) {
        if (that.isLeaf()) {
            return this;
        }
        
        int cmp = that.data().compareTo(this.data());
        if (cmp == 0) {
            return this.merge(that.left())
                       .merge(that.right());
        }
        if (cmp < 0) {
            return new BinBranch(this.data(),
                                 this.left().merge(that),
                                 this.right());
        }
        else {
            return new BinBranch(this.data(),
                                 this.left(),
                                 this.right().merge(that));
        }
    }


    @Override
    public BinTree<T> delete(T item) {
        int cmp = item.compareTo(this.data());
        if (cmp == 0) {
            return this.left().merge(this.right());
        }
        if (cmp < 0) {
            return this.left().delete(item);
        }
        else {
            return this.right().delete(item);
        }
    }
}
