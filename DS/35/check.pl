#!/usr/bin/perl
use 5.30.0;
use warnings FATAL => 'all';

while (<>) {
    chomp;
    /^(\S+)\s+(.*?)\s+(\d+\.\d+)$/ or die;
    say "$1\t$2\t$3";
}
