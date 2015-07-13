#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
int main()
{
    std::string rst,rst2;
    std::vector<int> rsts;

    for(int i=100;i<1000;i++){
        for(int j=100;j<1000;j++){
            rst = std::to_string(i*j);
            rst2 = std::string(rst.rbegin(),rst.rend());
            if(rst.compare(rst2)==0){
                rsts.push_back( std::stoi(rst)  );
            }
            else
                continue;
        }
    }
    std::cout<<rsts[rsts.size()-1]<<std::endl;
    return 0;
}
