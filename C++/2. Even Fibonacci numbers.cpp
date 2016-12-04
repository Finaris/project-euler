#include <iostream>

using namespace std;

int main() {
    int a = 1, b = 2, sum = 2, c;
    while(1) {
        for(int i = 1; i < 4; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        if(c >= 4000000) {
            break;
        }
        sum += c;
    }
    cout << sum << endl;
}