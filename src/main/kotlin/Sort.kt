
class Sort: Calculator() {
    fun selectionSort(arr: Array<Int>): Array<Int> {
        for(i in 0..arr.size) {
            var mid = i;
            for(j in i + 1..arr.size) {
                if(arr[mid] > arr[j]) {
                    mid = j
                }
            }
            var temp = arr[i]
            arr[i] = arr[mid]
            arr[mid] = temp
        }
        return arr;
    }
}