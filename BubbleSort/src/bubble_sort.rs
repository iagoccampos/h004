use rand::Rng;
use rand::thread_rng;
use std::time::Instant;

fn bubble_sort(vetor: &mut Vec<i32>, tamanho: usize) {
    let mut j = 0;
    let mut troca = true;
    let mut limite = tamanho - 1;

    while troca {
        troca = false;
        for i in 0..limite {
            if vetor[i] > vetor[i + 1] {
                let trab = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = trab;
                j = i;
                troca = true;
            }
        }

        limite = j;
    }
}

fn main() {
    let size = 99999;
    let mut array: Vec<i32> = (0..size).collect();
    let mut rng = thread_rng();
    rng.shuffle(&mut array);

    let start = Instant::now();
    bubble_sort(&mut array, size as usize);
    let duration = start.elapsed();

    println!("Bubble Sort: {}ms", duration.as_secs() * 1000 + duration.subsec_nanos() as u64 / 1_000_000);
}
