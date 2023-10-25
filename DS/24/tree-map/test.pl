#!/usr/bin/perl
use 5.26.0;
use warnings FATAL => 'all';
use feature qw(signatures);
no warnings "experimental::signatures";
use lib './.lib';

use Test::Simple tests => 18;
use Data::Dumper;

our %EXPECT_TESTS = (
    Prob1Should => 9,
    Prob2Should => 1,
    Prob3Should => 6,
    Prob4Should => 1,
);
our $PKG = "lab03";

use JUnit;

my @reports = JUnit::list_reports();

my %seen = map { $_ => 1 } @reports;
for my $xx (sort keys %EXPECT_TESTS) {
    my $name = "$PKG.$xx";
    unless (exists($seen{$name})) {
        say "# Test report missing: $name";
        say "# Giving up";
        exit(0);
    }

    ok(1, "Test output exists for $name");

    my $report = JUnit::read_report($name);

    my $jvers = $report->java_version();
    say "# Java VM: $jvers";

    my $summary = $report->summary();
    my $expect = $EXPECT_TESTS{$xx};
    my $ran = $summary->{tests};
    my $good = ($ran == $expect);
    if ($good) {
        ok(1, "Ran $expect tests in $name");
    }
    else {
        ok(0, "In $name, ran $ran, expected $expect tests");
    }
    ok($good && $summary->{fails} == 0, "Expected tests ran and no failures for $name");
    ok($good && $summary->{errors} == 0, "Expected tests ran and no errors for $name");
}

use CheckStyle;

my @errors = CheckStyle->list_errors();
my $count = scalar @errors;

ok($count < 10, "Less than 10 style errors");
ok($count == 0, "No style errors");

if ($count > 0) {
    say "#";
    say "# You had some style errors, here they are:";
    for my $err (@errors) {
        my $file = $err->{file};
        $file =~ s/^.*\///;
        my $line = $err->{line};
        my $text = $err->{text};
        say "#   $file:$line => $text";
    }
}
