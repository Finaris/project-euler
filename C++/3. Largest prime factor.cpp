#include <iostream>
#include <vector>

using namespace std;

bool isPrime (long long x);

int main () {
    long long largest, num = 600851475143;
    vector<long long> primes;
    for (long long i = 0; i*i < num; i++)
        if(isPrime(i))
            primes.push_back(i);
    for(vector<long long>::iterator it = primes.begin(); it != primes.end(); ++it) {
        if (num % *it == 0)
            largest = *it;
    }
    cout << largest << endl;
    return 0;
}

bool isPrime (long long x) {
    if (x == 0 || x == 1)
        return false;
    else if (x == 2)
        return true;
    else if (x % 2 == 0)
        return false;
    else {
        for (long long i = 3; i*i <= x; i += 2) {
            if (x % i == 0)
                return false;
        }
    }
    return true;
}