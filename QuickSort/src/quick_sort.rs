use rand::Rng;
use rand::thread_rng;
use std::time::Instant;

fn quick_sort(vetor: &mut Vec<i32>, tamanho: usize, i: usize, j: usize) {
    let mut esq = i as i32;
    let mut dir = j as i32;
    let pivo = vetor[((esq + dir) as f64 / 2.0).round() as usize];
    
    while esq <= dir {
        while vetor[esq as usize] < pivo {
            esq += 1;
        }
        
        while vetor[dir as usize] > pivo {
            dir -= 1;
        }
        
        if esq <= dir {
            let trab = vetor[esq as usize];
            vetor[esq as usize] = vetor[dir as usize];
            vetor[dir as usize] = trab;
            esq += 1;
            dir -= 1;
        }
    }
    
    if dir - i as i32 >= 0 {
        quick_sort(vetor, tamanho, i, dir as usize);
    }
    
    if j as i32 - esq >= 0 {
        quick_sort(vetor, tamanho, esq as usize, j);
    }
}

fn main() {
    let size = 99999;
    let mut array: Vec<i32> = (0..size).collect();
    let mut rng = thread_rng();
    rng.shuffle(&mut array);

    let start = Instant::now();
    quick_sort(&mut array, size as usize, 0, (size as usize) - 1);
    let duration = start.elapsed();

    println!("Qucik Sort: {}ms", duration.as_secs() * 1000 + duration.subsec_nanos() as u64 / 1_000_000);
}
