import matplotlib.pyplot as plt

# Execution times for each sorting algorithm
input_sizes = [5, 10, 100, 200, 300, 500, 1000, 2000]
bubble_sort_times = [0.0317, 0.0499, 0.150201, 0.5464, 1.2201, 0.407, 1.688601, 2.4405]
insertion_sort_times = [0.0388, 0.0189, 0.0359, 0.019001, 0.021, 0.0265, 0.0413, 0.0657]
selection_sort_times = [0.0282, 0.017801, 0.116601, 0.2663, 0.588, 0.3412, 1.2657, 0.8612]

# Plotting
plt.figure(figsize=(10, 7))

plt.plot(input_sizes, bubble_sort_times, marker='o', label='Bubble Sort', color='blue')
plt.plot(input_sizes, insertion_sort_times, marker='o', label='Insertion Sort', color='green')
plt.plot(input_sizes, selection_sort_times, marker='o', label='Selection Sort', color='red')

plt.title('Array Size vs Execution Time of Sorting Algorithms')
plt.xlabel('Array Size')
plt.ylabel('Execution Time (milliseconds)')
plt.legend()
plt.grid(True)
plt.show()
