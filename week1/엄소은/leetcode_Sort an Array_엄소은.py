from typing import List 

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        # merge sort
        
        def merge(left,right):
            i,j = 0,0
            sorted_list = []
            while i < len(left) and j < len(right):
                if left[i] < right[j]:
                    sorted_list.append(left[i])
                    i += 1
                else:
                    sorted_list.append(right[j])
                    j += 1
            while i < len(left):
                sorted_list.append(left[i])
                i += 1
            while j < len(right):
                sorted_list.append(right[j])
                j += 1
            return sorted_list

        def merge_sort(unsorted_list):
            if len(unsorted_list) < 2:
                return unsorted_list 
            mid = len(unsorted_list) // 2
            left = unsorted_list[:mid]
            right = unsorted_list[mid:]

            left_ = merge_sort(left)
            right_ = merge_sort(right)
            return merge(left_, right_)

        return merge_sort(nums)
            