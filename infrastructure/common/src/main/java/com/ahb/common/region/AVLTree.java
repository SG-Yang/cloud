package com.ahb.common.region;

import com.ahb.common.store.Store;
import com.ahb.common.store.StoreImpl;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Created by aheroboy on 20/3/2018.
 */
public class AVLTree<T extends Comparable> {
    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
    }

    private AvlNode<T> root;

    public AVLTree() {
        root = null;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        System.out.println("Sorry, remove unimplemented");
    }

    public T findMin() {
        if (isEmpty())
            System.out.println("empty tree!");
        ;
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty())
            System.out.println("empty tree");
        return findMax(root).element;
    }

    public boolean contains(T x) {
        return get(x, root) != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Collection<T> all() {
        return getAll(this.root);
    }

    private Collection<T> getAll(AvlNode<T> t) {
        Collection<T> locations = Collections.EMPTY_LIST;
        if (t != null) {
            locations.addAll(getAll(t.left));
            locations.add(t.element);
            locations.addAll(getAll(t.right));
        }
        return locations;
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null)
            return new AvlNode<T>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2)
                if (x.compareTo(t.left.element) < 0)
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (x.compareTo(t.right.element) > 0)
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
        } else {
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null)
            return t;
        while (t.left != null)
            t = t.left;
        return t;
    }

    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t == null)
            return t;
        while (t.right != null)
            t = t.right;
        return t;
    }

    private AvlNode<T> get(T x, AvlNode<T> t) {
        while (t != null) {
            int compareResult = x.compareTo(t.element);

            if (compareResult < 0)
                t = t.left;
            else if (compareResult > 0)
                t = t.right;
            else
                return t;
        }
        return null;
    }

    public T find(T x) {
        AvlNode<T> result = get(x, root);
        if (result != null) {
            return result.element;
        } else {
            return null;
        }
    }

    private void printTree(AvlNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    static class Location implements Comparable<Location> {
        private long size = 100;
        private long id;
        private Store store;

        public Location(long id) {
            this.id = id;
        }

        public Location(long id, int size, Store store) {
            this.id = id;
            this.store = store;
            this.size = size;
        }

        public Store getStore() {
            return store;
        }

        public void setStore(Store store) {
            this.store = store;
        }

        @Override
        public String toString() {
            return "id=" + id + ", store=" + store;
        }

        @Override
        public int compareTo(Location o) {
            if (o.id <= this.id && this.id < o.id + o.size) {
                return 0;
            } else if (this.id < o.id) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        AVLTree<Location> t = new AVLTree<>();
        List<Integer> index = Lists.newArrayList(10, 101, 201, 301, 401, 501, 601, 701, 801, 803, 900);
        AtomicInteger init = new AtomicInteger(0);
        index.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                t.insert(new Location(init.get(), integer, new StoreImpl()));
                init.set(init.get() + integer);
            }
        });

        t.printTree();
        index.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Contains:" + integer + " = " + t.contains(new Location(integer)) + ", result:" + t.find(new Location(integer)));
            }
        });

        System.out.println(t.contains(new Location(602)));
    }
}
