package chapter4

class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList<T> ()
): Collection<T> by innerList {}