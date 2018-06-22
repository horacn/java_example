package com.hz.example.algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 自定义 List 队列实现
 * @author hezhao
 * @Time   2016年3月18日 下午6:13:47
 * @Description 无
 * @version V 1.0
 * @param <E>
 */
public class MyArrayList<E> implements List<E> {
	private Object[] elementData;
	private int size;

	public MyArrayList(){
		elementData = new Object[10];
	}

	public MyArrayList(int initialLength){
		elementData = new Object[initialLength];
	}

	public boolean add(E element){
		return add_comm(size++, element);
	}

	public void add(int index,E element){
		if(index>size-1){
			throw new IndexOutOfBoundsException("当前size ["+size+"],不可插入下标为 ["+index+"] 的元素");
		}
		add_comm(index, element);
	}

	public boolean add_comm(int index,E element){
		elementData[index] = element;
		if(size==elementData.length){
			Object[] tempData = elementData.clone();
			elementData = new Object[(int)(size*1.5)+1];
			for (int i = 0; i < tempData.length; i++) {
				elementData[i] = tempData[i];
			}
		}
		return true;
	}

	public int size(){
		return size;
	}

	public E get(int index){
		if(index>size-1){
			throw new IndexOutOfBoundsException("当前size ["+size+"],不可得到下标为 ["+index+"] 的元素");
		}
		return (E) elementData[index];
	}

	@Override
	public boolean isEmpty() {
		return size==0 || elementData==null;
	}

	@Override
	public boolean contains(Object paramObject) {
		for (int i = 0; i < elementData.length; i++) {
			if(elementData[i] == paramObject){
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {

		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] arrays = new Object[size];
		for (int i = 0; i < size; i++) {
			arrays[i] = elementData[i];
		}
		return arrays;
	}

	@Override
	public <T> T[] toArray(T[] paramArrayOfT) {
		Object[] arrays = new Object[size];
		for (int i = 0; i < size; i++) {
			arrays[i] = elementData[i];
		}
		return (T[]) arrays;
	}

	@Override
	public boolean remove(Object paramObject) {
		Integer index = null;
		for (int i = 0; i < elementData.length; i++) {
			if(index!=null && i>index){
				elementData[i-1] = elementData[i];
			}else{
				if(elementData[i] == paramObject){
					index = i;
				}
			}
		}
		if(index!=null)	 size--;
		return index!=null;
	}

	public E remove(int index) {
		if(index>size-1){
			throw new IndexOutOfBoundsException("当前size ["+size+"],不可删除下标为 ["+index+"] 的元素");
		}
		E result = (E) elementData[index];
		for (int i = 0; i < elementData.length; i++) {
			if(i>index){
				elementData[i-1] = elementData[i];
			}
		}
		size--;
		return result;
	}

	@Override
	public boolean containsAll(Collection<?> paramCollection) {
		int count = 0;
		for (Object object : paramCollection) {
			if(contains(object))	count++;
		}
		return count == paramCollection.size();
	}

	@Override
	public boolean addAll(Collection<? extends E> paramCollection) {
		int count = 0;
		for (E ele : paramCollection) {
			if(add(ele))	count++;
		}
		return count == paramCollection.size();
	}

	@Override
	public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
		int count = 0;
		for (E ele : paramCollection) {
			if(paramInt>size-1){
				throw new IndexOutOfBoundsException("当前size ["+size+"],不可插入下标为 ["+paramInt+"] 的元素");
			}
			add_comm(paramInt++, ele);
			count++;
		}
		return count == paramCollection.size();
	}

	@Override
	public boolean removeAll(Collection<?> paramCollection) {
		int count = 0;
		for (Object obj : paramCollection) {
			if(remove(obj))	count++;
		}
		return count==paramCollection.size();
	}

	@Override
	public boolean retainAll(Collection<?> paramCollection) {
		return false;
	}

	@Override
	public void clear() {
		elementData = new Object[10];
		size = 0;
	}

	@Override
	public E set(int paramInt, E paramE) {
		if(paramInt>size-1){
			throw new IndexOutOfBoundsException("当前size ["+size+"],不可修改下标为 ["+paramInt+"] 的元素");
		}
		add_comm(paramInt, paramE);
		return (E) elementData[paramInt];
	}

	@Override
	public int indexOf(Object paramObject) {
		for (int i = 0; i < elementData.length; i++) {
			if(elementData[i] == paramObject){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object paramObject) {
		int index = -1;
		for (int i = 0; i < elementData.length; i++) {
			if(elementData[i] == paramObject){
				index = i;
			}
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int paramInt) {
		return null;
	}

	@Override
	public List<E> subList(int paramInt1, int paramInt2) {
		if(paramInt1<0){
			throw new IndexOutOfBoundsException("开始下标 ["+paramInt1+"] 不能小于0");
		}
		if(paramInt2<0){
			throw new IndexOutOfBoundsException("结束下标 ["+paramInt2+"] 不能小于0");
		}
		if(paramInt2>size-1){
			throw new IndexOutOfBoundsException("结束下标 ["+paramInt2+"] 不能大于集合最大下标["+(size-1)+"]");
		}
		if(paramInt1>paramInt2){
			throw new IndexOutOfBoundsException("开始下标 ["+paramInt1+"] 不能大于结束下标["+paramInt2+"]");
		}
		MyArrayList<E> newList = new MyArrayList<>(paramInt2-paramInt1);
		for (int i = paramInt1; i < paramInt2; i++) {
			newList.add((E) elementData[i]);
		}
		return newList;
	}

}
